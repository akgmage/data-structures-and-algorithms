class minMaxStack {
    constructor() {
        this.minMaxStack = [];
        this.stack = [];
    }
    //! O(1) time | O(1) space
    peek() {
        return this.stack[this.stack.length - 1];
    }
    //! O(1) time | O(1) space
    pop() {
        this.minMaxStack.pop();
        return this.stack.pop();
    }
    //! O(1) time | O(1) space
    push(number) {
        const newMinMax = {min: number, max: number};

        if(this.minMaxStack.length) {
            const lastMinMax = this.minMaxStack[this.minMaxStack.length - 1];
            newMinMax.min = Math.min(lastMinMax.min, number);
            newMinMax.min = Math.max(lastMinMax.max, number);
        }
        this.minMaxStack.push(newMinMax);
        this.stack.push(number);
    }
    //! O(1) time | O(1) space
    getMin() {
        return this.minMaxStack[this.minMaxStack.length - 1].min;
    }
    //! O(1) time | O(1) space
    getMax() {
        return this.maxMaxStack[this.maxMaxStack.length - 1].max;
    }

}