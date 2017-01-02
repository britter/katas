module Main

fizzbuzz : Int -> IO ()
fizzbuzz num = putStrLn fizzOrBuzz where
  fizzOrBuzz = cast num

main : IO ()
main = fizzbuzz 1
