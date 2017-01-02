module Main

fizzbuzz : Int -> IO ()
fizzbuzz num = putStrLn fizzOrBuzz where
  fizzOrBuzz =  if mod num 15 == 0
                then "fizzbuzz"
                else if mod num 3 == 0
                then "fizz"
                else if mod num 5 == 0
                then "buzz"
                else cast num

main : IO ()
main = fizzbuzz 15
