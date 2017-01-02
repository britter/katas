module Main

fizzbuzz : Int -> IO ()
fizzbuzz num = putStrLn fizzOrBuzz where
  fizzOrBuzz = if mod num 3 == 0 then "fizz" else cast num

main : IO ()
main = fizzbuzz 3
