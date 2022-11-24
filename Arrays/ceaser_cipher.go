package main

func CaesarCipherEncryptor(str string, key int) string {
	key = key % 26
	result := ""
	for i := 0; i < len(str); i++ {
		asciiValue := int(str[i]) + key
		if asciiValue > 122 {
			asciiValue -= 26
		}
		result += string(asciiValue)
	}
	return result
}
