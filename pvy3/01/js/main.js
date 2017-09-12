

function listOfAnimals(data, start, count){
    try { 
        if(isNaN(start) || isNaN(count)) throw "not a number";
        if(start < 0) throw "cannot be less than zero";
        if(start > data.length-1) throw "cannot be greater than lenght of data";
        if(count > data.length-1) throw "cannot be greater than lenght of data";
        
    }
    catch(err) {
        return '<div>Error: ' + err + '</div>';
    }
    var list = [];
    for(var i = start; i < start+count;i++){
        list.push(data[i]);
    }
    return (list.length > 0) ? list : '<p>no items</p>';
}

console.log(listOfAnimals(json,20,0));