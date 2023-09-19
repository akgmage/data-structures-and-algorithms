var numSub = function(s) {
    const MODULO = 10 ** 9 + 7;
    let current = result = 0;

    for (let index = 0; index <= s.length; index++) {
        const value = s[index];

        if (value === '1') current += 1;
        else {
            result = (result + (current + 1) * current / 2) % MODULO;
            current = 0;
        }
    }
    return result;
};
