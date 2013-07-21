/**
 * @(#)MenuService.java, 2013-7-8. 
 * 
 */
package com.cloudstone.emenu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.almworks.sqlite4java.SQLiteException;
import com.cloudstone.emenu.constant.Const;
import com.cloudstone.emenu.data.Chapter;
import com.cloudstone.emenu.data.Dish;
import com.cloudstone.emenu.data.IdName;
import com.cloudstone.emenu.data.Menu;
import com.cloudstone.emenu.data.MenuPage;
import com.cloudstone.emenu.exception.HttpStatusError;
import com.cloudstone.emenu.exception.ServerError;
import com.cloudstone.emenu.storage.db.IDishPageDb.DishPage;

/**
 * @author xuhongfeng
 *
 */
@Service
public class MenuService extends BaseService implements IMenuService {

    /* ---------- menu ---------- */
    @Override
    public void addMenu(Menu menu) {
        try {
            menuDb.addMenu(menu);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public void updateMenu(Menu menu) {
        try {
            menuDb.updateMenu(menu);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
        
    }

    @Override
    public void deleteMenu(long id) {
        try {
            menuDb.deleteMenu(id);
            deleteChaptersByMenuId(id);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public List<Menu> getAllMenu() {
        try {
            return menuDb.getAllMenu();
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public Menu getMenu(long id) {
        try {
            return menuDb.getMenu(id);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    /* --------- chapter ---------- */
    @Override
    public void addChapter(Chapter chapter) {
        try {
            chapterDb.addChapter(chapter);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public void updateChapter(Chapter chapter) {
        try {
            chapterDb.updateChapter(chapter);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
        
    }

    @Override
    public void deleteChapter(long id) {
        try {
            chapterDb.deleteChapter(id);
            List<MenuPage> pages = listMenuPageByChapterId(id);
            for (MenuPage page:pages) {
                deleteMenuPage(page.getId());
            }
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public List<Chapter> getAllChapter() {
        try {
            return chapterDb.getAllChapter();
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public Chapter getChapter(long id) {
        try {
            return chapterDb.getChapter(id);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public List<Chapter> listChapterByMenuId(long menuId) {
        try {
            return chapterDb.listChapters(menuId);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }
    
    public void deleteChaptersByMenuId(long menuId) {
        List<Chapter> chapters = listChapterByMenuId(menuId);
        for(Chapter chapter:chapters) {
            deleteChapter(chapter.getId());
        }
    }

    /* ---------- Dish ---------- */
    
    @Override
    public void bindDish(long menuPageId, long dishId, int pos) {
        try {
            dishPageDb.add(menuPageId, dishId, pos);
            checkDishInMenu(dishId);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }
    
    @Override
    public Dish addDish(Dish dish) {
        try {
            dishDb.add(dish);
            return dishDb.get(dish.getId());
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public List<Dish> getAllDish() {
        try {
            return dishDb.getAll();
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public void deleteDish(long id) {
        try {
            dishDb.delete(id);
            dishPageDb.deleteByDishId(id);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public Dish updateDish(Dish dish) {
        try {
            dishDb.update(dish);
            return dishDb.get(dish.getId());
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public Dish getDish(long id) {
        try {
            return dishDb.get(id);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }
    
    /* --------- MenuPage ---------- */
    @Override
    public void addMenuPage(MenuPage page) {
        try {
            menuPageDb.addMenuPage(page);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public void updateMenuPage(MenuPage page) {
        try {
            menuPageDb.updateMenuPage(page);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public void deleteMenuPage(long id) {
        try {
            //delete page
            menuPageDb.deleteMenuPage(id);
            List<DishPage> relation = dishPageDb.getByMenuPageId(id);
            dishPageDb.deleteByMenuPageId(id);
            for (DishPage r:relation) {
                long dishId = r.getDishId();
                checkDishInMenu(dishId);
            }
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }
    
    private void checkDishInMenu(long dishId) throws SQLiteException {
        Dish dish = dishDb.get(dishId);
        if (dish != null) {
            int count = dishPageDb.countByDishId(dishId);
            int oldStatus = dish.getStatus();
            int status = count==0? Const.DishStatus.STATUS_INIT : Const.DishStatus.STATUS_IN_MENU;
            if (status != oldStatus) {
                dish.setStatus(status);
                dishDb.update(dish);
            }
        }
    }

    @Override
    public List<MenuPage> getAllMenuPage() {
        try {
            return menuPageDb.getAllMenuPage();
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public List<MenuPage> listMenuPageByChapterId(long chapterId) {
        try {
            return menuPageDb.listMenuPages(chapterId);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }

    @Override
    public MenuPage getMenuPage(long id) {
        try {
            return menuPageDb.getMenuPage(id);
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }
    
    @Override
    public List<Dish> getDishByMenuPageId(long menuPageId) {
        List<Dish> ret = new ArrayList<Dish>();
        try {
            MenuPage page = getMenuPage(menuPageId);
            if (page == null) {
                throw new HttpStatusError(404);
            }
            Dish[] dishes = new Dish[page.getDishCount()];
            List<DishPage> relation = dishPageDb.getByMenuPageId(menuPageId);
            for (DishPage r:relation) {
                long dishId = r.getDishId();
                int pos = r.getPos();
                dishes[pos] = getDish(dishId);
            }
            for (int i=0; i<dishes.length; i++) {
                Dish dish = dishes[i];
                if (dish == null) {
                    dish = new Dish();
                    dish.setId(0-i); //id<0 means Null Dish
                }
                ret.add(dish);
            }
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
        return ret;
    }
    
    @Override
    public List<IdName> getDishSuggestion() {
        try {
            return dishDb.getDishSuggestion();
        } catch (SQLiteException e) {
            throw new ServerError(e);
        }
    }
    
}
