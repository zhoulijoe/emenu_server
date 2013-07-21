/*jslint browser: true, devel: true, indent: 4, nomen:true, vars: true */
/*global define */

define(function (require, exports, module) {
    "use strict";

    var BaseView = require('../BaseView');
    var $ = require('../lib/jquery');

    var Dialog = BaseView.extend({
        tagName: 'div',

        className: 'modal hide fade',

        header: null,

        model: null,

        ContentType: null,

        cancelLael: '取消',

        confirmLabel: '确定',

        events: {
            'click .btn-close-dialog': 'onClose',
            'click .btn-confirm-dialog': 'onConfirm'
        },

        tmpl: require('./Dialog.handlebars'),

        initialize: function () {
            BaseView.prototype.initialize.apply(this, arguments);

            this.$el.modal({
                keyboard: true
            });

            if (!this.header) {
                this.header = this.getHeader();
            }

            this.$el.on('hidden', function () {
                this.remove();
            }.bind(this));

            this.on('submit', this.onConfirm, this);
        },

        render: function () {
            BaseView.prototype.render.apply(this, arguments);
        
            if (this.ContentType) {
                var Content = this.ContentType;
                var contentView = new Content();
                contentView.render();
                this.$('.modal-body').append(contentView.el);
            }
        },

        getRenderData: function () {
            var data = BaseView.prototype.getRenderData.apply(this, arguments);
            data.header = this.header;
            data.cancelLael = this.cancelLael;
            data.confirmLabel = this.confirmLabel;

            return data;
        },

        show: function () {
            this.render();
            $('body').append(this.el);
            this.$el.modal('show');
        },

        hide: function () {
            this.$el.modal('hide');
        },

        getHeader: function () {
            return null;
        },

        /* -------------------- Event Listener ----------------------- */
        
        onClose: function (evt) {
            evt.preventDefault();
            this.hide();
        },
        
        onConfirm: function () {
        }
    });
    
    return Dialog;
    
});
