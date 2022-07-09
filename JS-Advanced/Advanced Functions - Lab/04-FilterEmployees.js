function solve(data, criteria){
    let db = JSON.parse(data);

    let criteriaTokens = criteria.split('-');
    let criteriaKey= criteriaTokens[0];
    let criteriaValue= criteriaTokens[1];

    db.filter(e=>e[criteriaKey]===criteriaValue)
        .forEach((e1,e2)=>
            console.log(`${e2}. ${e1.first_name} ${e1.last_name} - ${e1.email}`))
}

solve(`[{
    "id": "1",
    "first_name": "Kaylee",
    "last_name": "Johnson",
    "email": "k0@cnn.com",
    "gender": "Female"
  }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Johnson",
    "email": "kjost1@forbes.com",
    "gender": "Female"
  }, {
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
  }, {
    "id": "4",
    "first_name": "Evanne",
    "last_name": "Johnson",
    "email": "ev2@hostgator.com",
    "gender": "Male"
  }]`,
    'last_name-Johnson'
)