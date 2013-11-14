/**
 * Code Eval Programming Challenge - Decryption
 * 
 * @author Steven Chan
 */

var message = "012222 1114142503 0313012513 03141418192102 0113 2419182119021713 06131715070119";
var key = "BHISOECRTMGWYVALUZDNFJKPQX";
var alph = [];
var chars = {};

for (var i = 0; i < 26; i++) {
	alph[i] = String.fromCharCode(i + 65);
	chars[key.charAt(i)] = i;
}

var i = 0;
while (i < message.length) {
	var c = message.charAt(i);
	if (c === " ") {
		process.stdout.write(c);
		i++;
	} else {
		i++;
		c += message.charAt(i);
		var ch = alph[parseInt(c, 10)];
		var val = chars[ch];
		process.stdout.write(alph[val]);
		i++;
	}
}

process.stdout.write('\n');