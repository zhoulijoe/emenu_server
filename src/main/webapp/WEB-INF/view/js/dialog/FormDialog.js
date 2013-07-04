/*jslint browser: true, devel: true, indent: 4, nomen:true, vars: true */
/*global define */

define(function (require, exports, module) {
    "use strict";

    var Dialog = require('./Dialog');

    var FormDialog = Dialog.extend({
        FormType: null,

        initialize: function () {
            Dialog.prototype.initialize.apply(this, arguments);
        
            var Form = this.FormType;
            this.form = new Form({
                model: this.model
            });
        
            this.model.on('saved', function () {
                this.hide();
            }, this);
        },

        render: function () {
            Dialog.prototype.render.apply(this, arguments);
            this.form.init(this.$(this.formEl)[0]);
        },
        
        onConfirm: function () {
            Dialog.prototype.onConfirm.apply(this, arguments);
            this.form.trySubmit();
        }
        
    });
    
    return FormDialog;
    
});

