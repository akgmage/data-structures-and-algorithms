// Represent simple HTML document using Tree Data Structure

package main

/*
	<html>
		<body>
			<h1>This is a H1</h1>
			<h2>This is a H1</h2>
			<p>
			This is paragraph.
			<img src="https://image.com/image.png" alt="some logo"/>
			</p>
			<div class='someClass'>
			This is the footer of the page.
			<span id='spanId'>2022 &copy; AKGMAGE</span>
			</div>
		</body>
	</html>
*/

type Node struct {
	tag string
	text string
	src string
	alt string
	class string
	id string
	children []*Node
}

func FindByIDBFS(root *Node, id string) *Node {
	// make queue of type Node which will contain all the nodes 
	queue := make([]*Node, 0)
	queue = append(queue, root)
	for len(queue) > 0 {
		curr := queue[0] // set curr as first node
		queue = queue[1:] // remove first node from queue
		// return if match is found
		if curr.id == id {
			return curr
		}
		// if it has any children then queue it up
		if len(curr.children) > 0 {
			// dont care about the index, only care about the value
			for _, child := range curr.children {
				// add children in queue
				queue = append(queue, child)
			}
		}
	}
	return nil
}
func FindByIDBFS(node *Node, id string) *Node {
	if node.id == id {
		return node
	}
	if len(node.children) > 0 {
		for _, child := range node.children {
			FindByIDBFS(child, id)
		}
	}
}

func main() {
	span := Node {
		tag: "span",
		id: "spanId",
		text: "2022 &copy; AKGMAGE",
	}
	div := Node {
		tag: "div",
		class: "someClass",
		children: []*Node{&span},
	}
	image := Node{
		tag: "image",
		src: "https://image.com/image.png",
		alt: "some logo",
	}
	p := Node {
		tag: "p",
		text: "This is para.",
		children: []*Node{&image},
	}
	h1:= Node {
		tag: "h1",
		text: "This is h1",
	}
	h2:= Node {
		tag: "h2",
		text: "This is h2",
	}
	body := Node {
		tag: "body",
		children: []*Node{&div, &p, &h2, &h1},
	}
	html := Node {
		tag: "html",
		children: []*Node{&body},
	}
}