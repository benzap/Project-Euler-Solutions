(defproject problem-005 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/math.numeric-tower "0.0.4"]]
  :main ^:skip-aot problem-005.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

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

(def divisible-range-start 1)
(def divisible-range-end 10)

(defn is-divisible-in-range? [num start end]
  (let [prime-range (filter isprime? (range start end))
        is-common-factor (map #(zero? (mod num %)) prime-range)]
    (every? is-common-factor)))
