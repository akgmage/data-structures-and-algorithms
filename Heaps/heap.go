package main

type Item interface {
	Less(item Item) bool
}