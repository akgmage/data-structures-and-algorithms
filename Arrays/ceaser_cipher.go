package main

func CaesarCipherEncryptor(str string, key int) string {
	key = key % 26 // mod with 26 just in case the key is not bigger
	result := ""
	// find out ascii value if its greater than ascii value of 'z' then reduce 26 from value
	for i := 0; i < len(str); i++ {
		asciiValue := int(str[i]) + key
		if asciiValue > 122 {
			asciiValue -= 26
		}
		result += string(asciiValue)
	}
	return result
}
