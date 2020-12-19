module Main

putFizzbuzz : Int -> IO ()
putFizzbuzz num = putStrLn putFizzOrBuzz where
  putFizzOrBuzz =  if mod num 15 == 0
                then "fizzbuzz"
                else if mod num 3 == 0
                then "fizz"
                else if mod num 5 == 0
                then "buzz"
                else cast num

fizzbuzz : Int -> IO ()
fizzbuzz num = fizzbuzzes [1..num] where
  fizzbuzzes Nil = putStrLn ""
  fizzbuzzes (x :: xs) = do putFizzbuzz x
                            fizzbuzzes xs

main : IO ()
main = fizzbuzz 15
