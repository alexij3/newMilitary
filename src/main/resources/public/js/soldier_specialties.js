var app = angular.module("demo", []);

app.controller("SoldierSpecialtiesCtrl", function($scope, $http) {
    var soldierId;
    var soldierName;
    var soldierMilitaryBaseId;
    var soldierAge;
    var delSpecialties = [];
    var specialties = [];

    $scope.soldiers = [];
    var time = performance.now();
    $http.get('/api/soldier/showall').then(function (response) {
        time = performance.now() - time;
        window.alert("Виведення відбулося за " + time + " мс.");
        $scope.soldiers = response.data;
    });

    $http.get('/api/militarybase/showall').then(function(response) {
        var bases = response.data;
        var queryBase = document.getElementById('selectBase');

        for (var i = 0; i < bases.length; i++) {
            var option = document.createElement("option");
            option.text = bases[i].name;
            option.value = bases[i].id;

            queryBase.add(option);

            console.log(queryBase);
        }
    });

    $http.get('/api/army/showall').then(function(response) {
        console.log(response);
        var armies = response.data;
        var selectArmyQuery = document.getElementById('selectArmy');

        for (var k = 0; k < armies.length; k++){
            var option3 = document.createElement("option");
            option3.text = armies[k].name;
            option3.value = armies[k].id;

            selectArmyQuery.add(option3);
            console.log(selectArmyQuery);
        }

    });

    this.addSpecialties = function addSpecialties(){
        specialties = $scope.selectedSpecialties;
        var request = {
            method: 'PUT',
            url: '/api/soldier/updatespecialties?id=' + soldierId,
            data: {
                name : soldierName,
                age : soldierAge,
                specialty : specialties,
                militaryBaseId: soldierMilitaryBaseId
            }
        };

        var time = performance.now();
        $http(request).then(function(){
            time = performance.now() - time;
            window.alert("Створення відбулося за " + time + " мс.");
            window.location.reload();
        });
    };

    $http.get('/api/division/showall').then(function(response) {
        console.log(response);
        var divisions = response.data;
        var selectDivisionQuery = document.getElementById('selectDivision');

        for (var k = 0; k < divisions.length; k++){
            var option3 = document.createElement("option");
            option3.text = divisions[k].name;
            option3.value = divisions[k].id;

            selectDivisionQuery.add(option3);
            console.log(selectDivisionQuery);
        }


    });

    $http.get('/api/corps/showall').then(function(response) {
        console.log(response);
        var corps = response.data;
        var selectCorpsQuery = document.getElementById('selectCorps');

        for (var k = 0; k < corps.length; k++){
            var option3 = document.createElement("option");
            option3.text = corps[k].name;
            option3.value = corps[k].id;

            selectCorpsQuery.add(option3);
            console.log(selectCorpsQuery);
        }

    });

    $http.get('/api/brigade/showall').then(function(response) {
        console.log(response);
        var brigade = response.data;
        var select = document.getElementById('selectBrigade');

        for (var i = 0; i < brigade.length; i++) {
            var option = document.createElement("option");
            option.text = brigade[i].name;
            option.value = brigade[i].id;

            select.append(option);

            console.log(select);
        }
    });

    this.startAddSpecialties = function startAddSpecialties(id, name, age, militaryBaseId){
        soldierId = id;
        soldierName = name;
        soldierAge = age;
        soldierMilitaryBaseId = militaryBaseId;
        document.getElementById('soldierName').innerHTML = name;
    };

    this.startDeleteSpecialties = function startDeleteSpecialties(idSoldier, age, name, specialtiesToDelete, militaryBaseId){
        soldierId = idSoldier;
        soldierName = name;
        soldierMilitaryBaseId = militaryBaseId;
        soldierAge = age;
        document.getElementById('delSoldierName').innerHTML = name;

        specialties = specialtiesToDelete;
        var select = document.getElementById('delSelectSpecialties');

        for (var i = 0; i < specialties.length; i++) {
            var option = document.createElement("option");
            option.text = specialties[i];
            option.value = specialties[i];

            select.add(option);

            console.log(select);
        }
    };

    this.deleteSpecialties = function deleteSpecialties(){
        specialties = $('#delSelectSpecialties').val();
        var request = {
            method: 'POST',
            url: '/api/soldier/deletespecialties?soldierId=' + soldierId,
            data: {
                name : soldierName,
                specialty : specialties,
                militaryBaseId : soldierMilitaryBaseId,
                age : soldierAge
            }
        };

        var time = performance.now();
        $http(request).then(function(response){
            time = performance.now() - time;
            window.alert("Видалення відбулося за " + time + " мс.");
            document.getElementById('delSelectSpecialties').options.length = 0;
            window.location.reload();
        });
    };

    function removeItems(selectBox){
        for (var i = selectBox.length-1; i >= 0; i--){
            selectBox.remove(i);
        }
    }

    this.onClose = function onClose(){
        removeItems(document.getElementById('delSelectSpecialties'));
    };


    /**
     * QUERIES
     */

    this.selectBySpecialtyAndArmy = function selectBySpecialtyAndArmy(){
        var specialty = $('#selectSpecialty').val();
        var id = $('#selectArmy').val();

        $http.get('/api/soldier/findAllBySpecialtyContainingAndMilitaryBaseArmyId?specialty=' + specialty + '&id=' + id).then(function(response){
            $scope.soldiers = response.data;
        });
    };

    this.selectBySpecialtyAndBase = function selectBySpecialtyAndBase(){
        var specialty = $('#selectSpecialtyBase').val();
        var id = $('#selectBase').val();

        $http.get('/api/soldier/findAllBySpecialtyContainingAndMilitaryBaseId?specialty=' + specialty + '&id=' + id).then(function(response){
            $scope.soldiers = response.data;
        });
    };

    this.selectBySpecialtyAndDivision = function selectBySpecialtyAndDivision(){
        var specialty = $('#selectSpecialtyDivision').val();
        var id = $('#selectDivision').val();

        $http.get('/api/soldier/findAllBySpecialtyContainingAndMilitaryBaseDivisionId?specialty=' + specialty + '&id=' + id).then(function(response){
            $scope.soldiers = response.data;
        });
    };

    this.selectBySpecialtyAndCorps = function selectBySpecialtyAndCorps(){
        var specialty = $('#selectSpecialtyDivision').val();
        var id = $('#selectCorps').val();

        $http.get('/api/soldier/findAllBySpecialtyContainingAndMilitaryBaseCorpsId?specialty=' + specialty + '&id=' + id).then(function(response){
            $scope.soldiers = response.data;
        });
    };

    this.selectBySpecialtyAndBrigade = function selectBySpecialtyAndBrigade(){
        var specialty = $('#selectSpecialtyDivision').val();
        var id = $('#selectBrigade').val();

        $http.get('/api/soldier/findAllBySpecialtyContainingAndMilitaryBaseBrigadeId?specialty=' + specialty + '&id=' + id).then(function(response){
            $scope.soldiers = response.data;
        });
    };
});