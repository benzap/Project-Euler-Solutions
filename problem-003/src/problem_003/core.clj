(ns problem-003.core
  (:require [clojure.math.numeric-tower :as math])
  (:gen-class))

(def test-number 13195)

(def max-divisor 200)

(def num 600851475143)

(defn isprime? [num]
  (cond
   (< num 2) false
   (= num 2) true
   (= num 3) true
   (zero? (mod num 2)) false
   (zero? (mod num 3)) false
   (let [max-divisor (int (math/ceil (math/sqrt num)))
         num-seq (range 5 max-divisor 6)
         num-mod (filter #(or (zero? (mod num %))
                              (zero? (mod num (+ 2 %)))) num-seq)]
     (empty? num-mod)) true
     :else false))

(isprime? 29)

(defn prime-factors [num]
  (let [max-divisor (int (math/ceil (math/sqrt num)))
        seq-primes (filter #(isprime? %) (range max-divisor))]
    (filter #(zero? (mod num %)) seq-primes)))

(apply max (prime-factors 13195))

(defn soln []
  (apply max (prime-factors 600851475143)))

(prime-factors 100000000)

 
(defn -main
  "Solution to problem 3"
  [& args]
  (soln))
