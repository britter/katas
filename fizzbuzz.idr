module Main

fizzbuzz : String -> IO ()
fizzbuzz str = putStrLn greeting where
  greeting : String
  greeting = "Hello, " ++ str ++ "!"

main : IO ()
main = fizzbuzz "Idris"
