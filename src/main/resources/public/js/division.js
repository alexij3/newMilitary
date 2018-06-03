var app = angular.module("demo", []);

app.controller("DivisionCtrl", function($scope, $http){
    var idToUpdate;

    var time = performance.now();
    $scope.division = [];
     $http.get('/api/division/showall').then(function (response){
         time = performance.now() - time;
         window.alert("Виведення відбулося за " + time + " мс.");
        $scope.division=response.data;
        console.log(response);
    });

    this.deleteDivision = function deleteDivision(id){
        var time = performance.now();
        $http.get('/api/division/delete?id=' + id).then(function(){
            time = performance.now() - time;
            window.alert("Видалення відбулося за " + time + " мс.");
            window.location.reload();
        });
    };

    this.createDivision = function createDivision(){
        var name = document.getElementById('divisionName').value;
        var codeNumber = document.getElementById('divisionCode').value;
        var createRequest = {
            method: 'PUT',
            url: '/api/division/create',
            data : {
                codeNumber : codeNumber,
                name : name
            }
        };

        var time = performance.now();
        $http(createRequest).then(function(response){
            time = performance.now() - time;
            window.alert("Створення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    };

    this.startUpdateDivision = function startUpdateDivision(id, name, code){
        document.getElementById('updateDivisionName').value = name;
        document.getElementById('updateDivisionCode').value = code;
        idToUpdate = id;
    };

    this.updateDivision = function updateDivision(){
        var name = document.getElementById('updateDivisionName').value;
        var codeNumber = document.getElementById('updateDivisionCode').value;
        var request = {
            method: 'POST',
            url : '/api/division/update?id=' + idToUpdate,
            data: {
                codeNumber : codeNumber,
                name : name
            }
        };

        var time = performance.now();
        $http(request).then(function (response){
            time = performance.now() - time;
            window.alert("Оновлення відбулося за " + time + " мс.");
            console.log(response);
            window.location.reload();
        });
    };

    this.getDivision = function getDivision(id){
        $http.get('/api/division/get?id=' + id);
    };

    this.selectByMaxBases = function selectByMaxBases(){
        $http.get('/api/division/findByMaxBases').then(function(response){
            $scope.division = response.data;
        });
    };

    this.selectByMinBases = function selectByMinBases(){
        $http.get('/api/division/findByMinBases').then(function(response){
            $scope.division = response.data;
        });
    };
});



