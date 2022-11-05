# Hungry-Penguin
# Depth-First-Search-Algorithm
In this assignment, Pingu should be helped on its search for fish. Pingu lives in a world of rectangular shape which is sub-divided into tiles or fields. Each individual field may represent different terrains where the field occupied by pingu before a move determines how she may proceed during the move. Pingu starts at a particular field and may perform arbitrarily many moves. This program's task is, for a given world and a given initial position of Pingu, to determine whether Pingu may reach a field containing a fish with the help of the DNF algorithm.

0: Land: on land, Pingu is slow. Pingy may proceed in each direction (i.e., left, right, up or down) only by a single field.
1: Ice: ice is slippery! Pingu may only proceed along one of the diagonals by a single field.
2: Water: from this field, Pingu may proceed in any of the diagonals exactly three fields. The two fields in-between are jumped over.
3: Shark: Danger! Pingu must not stay on a field with a shark and thus also not perform a move ending on such a field.
4: Fish: This is the place of Pingu's strongest desire!
