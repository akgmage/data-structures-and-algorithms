

func main() {
	s := "Mr John Smith               ";
	nRunes := utf8.RuneCountInString(s)
		runes := make([]rune, nRunes)
		for i, r := range s {
			runes[i] = r