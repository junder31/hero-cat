//= wrapped
//= require /angular/angular
//= require /angular/angular-route
//= require /hero/cat/core/hero.cat.core
//= require /hero/cat/list/hero.cat.list

angular.module('hero.cat', [
    'ngRoute',
    'hero.cat.core',
    'hero.cat.list'
]).config(['$routeProvider',
    function config($routeProvider) {
        $routeProvider.
            when('/heros', {
                template: '<hero-list></hero-list>'
            }).
            otherwise('/heros');
    }
]);
