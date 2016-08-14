//= wrapped
//= require /angular/angular
//= require /angular/angular-route
//= require /hero/cat/core/hero.cat.core
//= require /hero/cat/list/hero.cat.list
//= require /hero/cat/detail/hero.cat.detail

angular.module('hero.cat', [
    'ngRoute',
    'hero.cat.core',
    'hero.cat.list',
    'hero.cat.detail',
]).config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
        $locationProvider.hashPrefix('!');

        $routeProvider.
            when('/heros', {
                template: '<hero-list></hero-list>'
            }).
            when('/heros/:heroId', {
                template: '<hero-detail></hero-detail>'
            }).
            otherwise('/heros');
    }
]);
