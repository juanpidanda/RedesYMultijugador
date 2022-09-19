var humanName, humanLastName;
var humanAge, agonyAge, tormentAge;

function popup(){
	alert("Welcome Misery Walker!")
}
function popup2(){
	alert("F*ck yourself then :*")
}
function agonyAge(a, b){
	return a * b ;
}
function tormentAge(a, b){
	return a + b;
}
function miseryThoughtsCalculator(){
	humanName = prompt("What is your human name?");
	humanLastName = prompt("What is your human last name (both)");
	humanAge = prompt("What is your age?");
	alert("Calculating your thoughts... click Accept");
	agonyAge = agonyAge(humanName.length, humanAge);
	tormentAge = tormentAge(humanLastName.length, humanAge);
	alert("Welcome: " + humanName + " " + humanLastName + ".\n" + "You have " + agonyAge + " thoughts in Agony." + " And " + tormentAge + " thoughts in Torment.");
}