# GGBond User Guide

  ____  ____ ____                  _ 
 / ___|/ ___| __ )  ___  _ __   __| |
| |  _| |  _|  _ \ / _ \| '_ \ / _` |
| |_| | |_| | |_) | (_) | | | | (_| |
 \____|\____|____/ \___/|_| |_|\__,_|

GGBond is a lightweight, terminal-based task manager designed for efficient organization. 
It helps you track simple tasks, strict deadlines, and timed events through an intuitive Command Line Interface (CLI).

## Adding todos

Adds a basic task without any specific time or date constraints. This is ideal for quick reminders or simple "to-do" items.

Command: `todo [description]`

Example: `todo read textbook`

GGBond adds the task with the `[T]` identifier and updates your total task count.

```
----------------------------------------------------
Got it. I've added this task:
[T][ ] read textbook
Now you have 4 tasks in the list
----------------------------------------------------
```

## Adding deadlines

Adds a task that has a specific completion date. GGBond parses the date and stores it in a standardized format, allowing you to see exactly how much time you have left.

Command: `deadline [description] /by [yyyy-mm-dd]`

Example: `deadline Submit CG2028 report /by 2026-03-20`

A confirmation message is displayed showing the task type `[D]`, the completion status `[ ]`, and the formatted date.

```
----------------------------------------------------
Got it. I've added this task:
[D][ ] Submit CG2028 report (by: Mar 20 2026)
Now you have 3 tasks in the list
----------------------------------------------------
```

## Adding events

Adds a task that occurs within a specific duration. This requires both a start and an end time.

Command: `event [description] /from [start] /to [end]`

Example: `event Project meeting /from 2pm /to 4pm`

The task is saved with the `[E]` identifier, showing the full time range in the output.
```
----------------------------------------------------
Got it. I've added this task:
[E][ ] Project meeting (from: 2pm to: 4pm)
Now you have 6 tasks in the list
----------------------------------------------------
```

## Listing all tasks

Displays every task currently stored in your task list, showing their type, completion status, and any associated dates or times.

Command: `list`

GGBond iterates through your entire collection and prints a numbered list. This is useful for getting a quick overview of your current progress.

```
----------------------------------------------------
Here are the tasks in your list:
1.[T][ ] read textbook
2.[D][X] Submit CG2028 report (by: Mar 20 2026)
3.[E][ ] Project meeting (from: 2pm to: 4pm)
----------------------------------------------------
```

## Finding tasks

Searches your existing task list for any entries containing a specific keyword in their description.

Command: `find [keyword]`

Example: `find Project`

GGBond filters the list and displays only the tasks that match your search query.
```
----------------------------------------------------
Here are the matching tasks in your list:
1.[D][X] CS2113 Project (by: Mar 20 2026)
----------------------------------------------------
```

## Deleting tasks

Removes a task permanently from your list using its corresponding index number.

Command: `delete [index]`

Example: `delete 1`

GGBond confirms the removal of the specific task and provides the updated count of remaining tasks.

```
----------------------------------------------------
Noted. I've removed this task:
[D][X] CS2113 Project (by: Mar 20 2026)
Now you have 5 tasks in the list.
----------------------------------------------------
```

## Marking tasks as completed

Updates a task's status to indicate it has been finished. This changes the status icon from an empty space to an `X`.

Command: `mark [index]`

Example: `mark 2`

```
----------------------------------------------------
Nice! I've marked this task as done:
[D][X] CS2113 Project (by: Mar 20 2026)
----------------------------------------------------
```

## Marking tasks as completed

Updates a task's status to indicate it has not been done. This changes the status icon from an `X` to an empty space.

Command: `unmark [index]`

Example: `unmark 2`

```
----------------------------------------------------
Noted, I've marked this task as not done yet:
[D][ ] CS2113 Project (by: Mar 20 2026)
----------------------------------------------------
```

## Exiting the program

Safely terminates the session. GGBond ensures all current tasks are written to `./data/GGBond.txt` before closing.

Command: `bye`
```
----------------------------------------------------
Bye. Hope to see you again soon!
----------------------------------------------------
```
