// Represent simple HTML document using Tree Data Structure

package main

/*
	<html>
	<h1>This is h1</h1>
	<h2>This is h2</h2>
	<p>This is para.</p>
	</html>
*/
type Node struct {
	tag string
	text string
	children []*Node
}

func main() {
	p := Node {
		tag: "p",
		text: "This is para.",
	}
	h1:= Node {
		tag: "h1",
		text: "This is h1",
	}
	h2:= Node {
		tag: "h2",
		text: "This is h2",
	}
	html := Node {
		tag: "html",
		children: []*Node{&p, &h2, &h1},
	}
}