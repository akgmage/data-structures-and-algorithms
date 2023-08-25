def divide(dividend, divisor):
    if divisor == 0:
        raise ZeroDivisionError("Division by zero")
    if dividend == 0:
        return 0

    negative = (dividend < 0) ^ (divisor < 0)
    dividend = abs(dividend)
    divisor = abs(divisor)

    quotient = 0
    while dividend >= divisor:
        dividend -= divisor
        quotient += 1

    if negative:
        quotient = -quotient

    INT_MAX = 2**31 - 1
    INT_MIN = -2**31
    if quotient > INT_MAX:
        return INT_MAX
    elif quotient < INT_MIN:
        return INT_MIN
    else:
        return quotient

# Take user input for dividend and divisor
dividend = int(input("Enter the dividend: "))
divisor = int(input("Enter the divisor: "))

# Perform the division and print the result
result = divide(dividend, divisor)
print(f"The result of {dividend} divided by {divisor} is: {result}")
