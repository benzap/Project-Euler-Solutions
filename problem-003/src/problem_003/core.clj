(ns problem-003.core
  (:gen-class))

(def test-number 13195)

(defn isprime? [num]
  (cond
   (= num 0) false
   (= num 1) false
   (= num 2) true
   (= num 3) true
   (even? num) false
   (let [num-seq (range 2 num)
         num-mod (filter #(zero? (mod num %)) num-seq)]
     (empty? num-mod)) true
     :else false))

(isprime? 13)

(defn prime-factors [num]
  (let [seq-primes (filter #(isprime? %) (range num))]
    (filter #(zero? (mod num %)) seq-primes)))

(apply max (prime-factors 13195))

(defn soln []
  (apply max (prime-factors 600851475143)))
 
(defn -main
  "Solution to problem 3"
  [& args]
  (soln))
