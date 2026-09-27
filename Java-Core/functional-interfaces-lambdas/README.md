# Java Labs — Functional Interfaces, Lambdas, Method References & Streams

## Structure

```
lab1-functional-interfaces-lambdas/
  starter/    ← give these to students (contain TODOs, won't compile until filled in)
  solution/   ← your answer key, fully working

lab2-method-references/
  starter/
  solution/

lab3-streams/
  starter/
  solution/
  lab3-streams-guide.md   ← Obsidian-formatted version with collapsible solutions
```

Each exercise is a single, independent `.java` file with its own `public class` and a `main` method — no build tool needed, and no dependencies between exercises.

## How to run a file

Compile and run any single exercise directly:

```bash
javac Exercise1_2_Discount.java
java Exercise1_2_Discount
```

Or, to compile every solution in a folder at once:

```bash
cd lab1-functional-interfaces-lambdas/solution
javac *.java
for f in *.class; do java "${f%.class}"; echo "---"; done
```

## In an IDE (IntelliJ / Eclipse / VS Code)

Just open the `starter` or `solution` folder as a project/folder — each file is self-contained, so students can run them individually with the IDE's "Run" button on `main`.

## Suggested flow for the session

1. Hand out the `starter/` files for Lab 1 first — walk through Exercise 1.2 → 1.6 in order, since each builds on the previous concept.
2. Move to Lab 2's `starter/` files once functional interfaces + lambdas feel solid.
3. Exercise 2.5 is a "predict before you run" trick question — have students guess out loud before compiling it.
4. Reveal `solution/` files only after each exercise, or at the end, depending on your pacing.

## Exercise index

| Lab | Exercise | File | Concept |
|---|---|---|---|
| 1 | 1.2 | `Exercise1_2_Discount.java` | Custom functional interface + anonymous classes |
| 1 | 1.3 | `Exercise1_3_DiscountLambdas.java` | Anonymous class → lambda |
| 1 | 1.4 | `Exercise1_4_BuiltInInterfaces.java` | `Predicate`, `Function`, `Consumer`, `Supplier` together |
| 1 | 1.5 | `Exercise1_5_EffectivelyFinal.java` | Effectively-final capture bug |
| 1 | 1.6 | `Exercise1_6_TransformAll.java` | Passing behavior into a generic method |
| 2 | 2.2 | `method_ref.Exercise2_2_ConvertToMethodRefs.java` | Lambda → all 4 method reference types |
| 2 | 2.3 | `method_ref.Exercise2_3_MiniPipeline.java` | Static + bound instance references, pre-Streams |
| 2 | 2.4 | `method_ref.Exercise2_4_ConstructorReference.java` | Constructor reference |
| 2 | 2.5 | `method_ref.Exercise2_5_DebuggingChallenge.java` | Unbound instance reference (`String::concat`) |
| 3 | 3.1 | `Exercise3_1_CreatingStreams.java` | Creating streams (collection, IntStream, infinite) |
| 3 | 3.2 | `Exercise3_2_FilterMap.java` | `filter` + `map` |
| 3 | 3.3 | `Exercise3_3_FlatMap.java` | `flatMap` |
| 3 | 3.4 | `Exercise3_4_SortDistinctLimitSkip.java` | `sorted`, `distinct`, `skip`, `limit` |
| 3 | 3.5 | `Exercise3_5_Reduce.java` | `reduce` with and without identity |
| 3 | 3.6 | `Exercise3_6_MatchOperations.java` | `anyMatch` / `allMatch` / `noneMatch` |
| 3 | 3.7 | `Exercise3_7_FindFirstMinMax.java` | `findFirst`, `min`, `max` |
| 3 | 3.8 | `Exercise3_8_GroupingByJoining.java` | `Collectors.groupingBy` + `joining` |
| 3 | 3.9 | `Exercise3_9_SumOfSquares.java` | `mapToInt` + `sum` (primitive streams) |
| 3 | 3.10 | `Exercise3_10_Capstone.java` | Full pipeline + `Collectors.averagingDouble` |
