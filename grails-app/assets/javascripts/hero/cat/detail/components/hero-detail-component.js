//= wrapped

angular
    .module('hero.cat.detail')
    .component('heroDetail', {
        templateUrl: 'static/templates/hero-detail.html',
        controller: ['$scope', '$routeParams', 'Hero',
            function HeroDetailController($scope, $routeParams, Hero) {
                var self = this;

                Hero.query({characterId: $routeParams.heroId}, function (response) {
                    self.hero = response.data.results[0];
                });
            }
        ]
    });
