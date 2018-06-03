var app = angular.module("demo", []);

app.controller("SoldierCtrl", function($scope, $http){
    var idToUpdate;
    var specialties = [];

    var time = performance.now();
    $scope.soldier = [];
     $http.get('/api/soldier/showall').then(function (response){
         time = performance.now() - time;
         window.alert("Виведення відбулося за " + time + " мс.");
         $scope.soldier=response.data;
         console.log(response);

         $http.get('/api/militarybase/showall').then(function(response){
             var militaryBases = response.data;
             var select = document.getElementById('selectMilitaryBases');
             var selectMbaseUpd = document.getElementById('updateMilitaryBase');

             for (var i = 0; i < militaryBases.length; i++){
                 var option = document.createElement("option");
                 option.text = militaryBases[i].name;
                 option.value = militaryBases[i].id;

                 select.add(option);
                 console.log(select);
             }

             for (var j = 0; j < militaryBases.length; j++){
                 var option2 = document.createElement("option");
                 option2.text = militaryBases[j].name;
                 option2.value = militaryBases[j].id;

                 selectMbaseUpd.add(option2);
             }
         });
    });

    this.deleteSoldier = function deleteSoldier(id){
        var time = performance.now();
        $http.get('/api/soldier/delete?id=' + id).then(function(){
            time = performance.now() - time;
            window.alert("Видалення відбулося за " + time + " мс.");
            window.location.reload();
        });
    };

    this.createSoldier = function createSoldier(){
        var name = document.getElementById('soldierName').value;
        var age = document.getElementById('soldierAge').value;
        var militaryBaseId = document.getElementById('selectMilitaryBases').value;

        var createRequest = {
            method: 'PUT',
            url: '/api/soldier/create?mbaseId=' + militaryBaseId,
            data : {
                name : name,
                age : age
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

    this.startUpdateSoldier = function startUpdateSoldier(id, name, age, militaryBaseId, specialty){
        document.getElementById('updateMilitaryBase').value = militaryBaseId;
        document.getElementById('updateSoldierAge').value = age;
        document.getElementById('updateSoldierName').value = name;
        specialties = specialty;
        idToUpdate = id;
    };

    this.updateSoldier = function updateSoldier(){
        var name = document.getElementById('updateSoldierName').value;
        var age = document.getElementById('updateSoldierAge').value;
        var militaryBaseId = document.getElementById('updateMilitaryBase').value;

        var request = {
            method: 'POST',
            url : '/api/soldier/update?id=' + idToUpdate + '&mbaseId=' + militaryBaseId,
            data: {
                name : name,
                age : age,
                specialty : specialties
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

    this.getSoldier = function getSoldier(id){
        $http.get('/api/soldier/get?id=' + id);
    }
});



