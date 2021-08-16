# Message Encryption Decryption Application

```bash
-mode enc               # to ecnrypt
-mode dec               # to decrypt
                        # program works in enc mode by default
```

```bash
-key 5                  # for offset key 5
-key 10                 # for offset key 10
                        # zero by default
```

```bash
-data "Sample text"     # takes "Sample text" as source data
                        # empty string by default
                        # program prefers -data over -in.
```

```bash
-in input.txt           # takes data from file "input.txt"
                        # if there is no -data or -in data is empty string
```

```bash
-out output.txt         # saves data to file "output.txt"
                        # if there is no -out argument the program prints data to the standard output
```

```bash
-alg shift              # uses Caesar Cipher to decrypt/encrypt message
-alg unicode            # uses Unicode based algorithm
```

Examples of usage:

```bash
java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode
```

```bash
java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
```




