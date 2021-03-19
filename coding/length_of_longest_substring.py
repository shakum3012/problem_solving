"""

O(n) solution for finding the longest substring without a repeating character

Algorithm:
consider string "abcabc"
start = 0
end = 0
seen_char = {}
We iterate each character and keep track of the last position the character was seen in
a map.

at i = 4
seen_char = {a: 0, b:1, c:2}
start = 0
end = 3
cur_char = a

As we have already seen 'a' at position 0 the substring without the repeating a will be starting
from 0 + 1 = position 1. So we update the start and the last seen position of a
seen_char = {a: 4, b:1, c:2}
start = 1
end = 4

Further, there is a case where the last seen position might be less than the start. In this case we just update
the last seen position of the character and end position alone. We dont consider it as a duplicate as its before
the start of the substring. see line 44 in the code for the check.

The algorithm moves forward similarly calculating and updating the max_len as it moves.
"""


def length_of_longest_substring(s):
    max_len = 0
    start = 0
    end = 0
    seen_char = {}
    if len(s) == 0:
        return 0

    for i in range(len(s)):
        cur_char = s[i]
        if cur_char in seen_char:
            if seen_char[cur_char] < start:
                seen_char[cur_char] = i
                end = i
                continue
            cur_len = end - start + 1
            if max_len < cur_len:
                max_len = cur_len
            start = seen_char[cur_char] + 1
            seen_char[cur_char] = i
        else:
            seen_char[cur_char] = i
        end = i
    cur_len = end - start + 1
    if max_len < cur_len:
        max_len = cur_len
    return max_len


print(length_of_longest_substring("abcabc"))

