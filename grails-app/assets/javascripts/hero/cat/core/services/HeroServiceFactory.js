//= wrapped

angular
    .module('hero.cat.core')
    .factory('Hero', ['$resource',
        function ($resource) {
            return $resource('hero/v1/public/characters/:characterId', {}, {
                list: {
                    metohd: 'GET'
                }
            });
        }
    ]);
