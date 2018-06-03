var app = angular.module("demo", []);

app.controller("SquadronCtrl", function($scope, $http){
    var idToUpdate;

    var time = performance.now();
    $scope.squadron = [];
     $http.get('/api/squadron/showall').then(function (response){
         time = performance.now() - time;
         window.alert("Виведення відбулося за " + time + " мс.");
        $scope.squadron=response.data;
        console.log(response);
         $http.get('/api/militarybase/showall').then(function(response){
             var militaryBases = [];
             militaryBases = response.data;
             var select = document.getElementById('militaryBase');
             var selectMilitaryBaseUpd = document.getElementById('updateMilitaryBase');

             for (var i = 0; i < militaryBases.length; i++) {
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

                 selectMilitaryBaseUpd.add(option2);
                 console.log(selectMilitaryBaseUpd);
             }
         });
    });


    this.deleteSquadron = function deleteSquadron(id){
        var time = performance.now();
        $http.get('/api/squadron/delete?id=' + id).then(function(){
            time = performance.now() - time;
            window.alert("Видалення відбулося за " + time + " мс.");
            window.location.reload();
        });
    };

    this.createSquadron = function createSquadron(){
        var militaryBaseId = document.getElementById('militaryBase').value;
        var name = document.getElementById('squadronName').value;
        var codeNumber = document.getElementById('squadronCode').value;
        var createRequest = {
            method: 'PUT',
            url: '/api/squadron/create?mbaseId=' + militaryBaseId,
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

    this.startUpdateSquadron = function startUpdateSquadron(id, mbaseId, name, code){
        document.getElementById('updateMilitaryBase').value = mbaseId;
        document.getElementById('updateSquadronName').value = name;
        document.getElementById('updateSquadronCode').value = code;
        idToUpdate = id;
    };

    this.updateSquadron = function updateSquadron(){
        var militaryBaseId = document.getElementById('updateMilitaryBase').value;
        var name = document.getElementById('updateSquadronName').value;
        var codeNumber = document.getElementById('updateSquadronCode').value;
        var request = {
            method: 'POST',
            url : '/api/squadron/update?id=' + idToUpdate + '&mbaseId=' + militaryBaseId,
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

    this.getSquadron = function getSquadron(id){
        $http.get('/api/squadron/get?id=' + id);
    }
});



