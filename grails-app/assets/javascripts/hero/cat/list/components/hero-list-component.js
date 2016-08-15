//= wrapped

angular
    .module('hero.cat.list')
    .component('heroList', {
        templateUrl: 'static/templates/hero-list.html',
        controller: ['$scope', 'Hero',
            function HeroListController($scope, Hero) {
                $scope.$watch('query', function (newValue, oldValue) {
                    var params = newValue ? {nameStartsWith: newValue} : {};

                    Hero.query(params, function (response) {
                        $scope.heros = response.data.results;
                    });
                });
            }
        ]
    });
