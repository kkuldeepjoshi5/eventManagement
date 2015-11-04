(function(define, angular) {
	"use strict";

	define(['app-ctrl','home/home-module','contactUs/contactUs-module','about/about-module','gallery/gallery-module'
	        ,'ourServices/ourServices-module','profile/profile-module','event/event-module'],
			function(AppCtrl,homePage,contactUs,about,gallery,ourService,profile,event) {

		/**
         * Specify main application dependencies...
         * one of which is the Authentication module.
         *
         * @type {Array}
         */
		var app, appName = "app.eventManagment";

		/**
         * Start the main application
         *
         * We manually start this bootstrap process; since ng:app is gone
         * ( necessary to allow Loader splash pre-AngularJS activity to finish properly )
         */

		app = angular.module(appName, ['ngRoute',/*'chieffancypants.loadingBar', */'ngAnimate',homePage,contactUs,about,gallery,ourService,profile,,event])
		                               .controller('AppCtrl', AppCtrl);


        angular.bootstrap(document.getElementsByTagName("html")[0], [appName]);
        return app;
	});

}(define, angular));