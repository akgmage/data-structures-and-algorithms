package bitmanipulation

import (
	"testing"
	"regexp"
)

func TestCountBits(t *testing.T) {
	msg, err := CountBits(5)
	if msg != 2 && err != nil {
		t.Fatalf(`CountBits(5) = %q %v, want "", error`, msg, err)
	}

}