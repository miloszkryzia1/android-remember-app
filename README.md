# _Remember_ 
# Android Application inspired by Trello
## Description
_This is a personal learning/portfolio project._

This Android application is inspired by and features similar functionality to Trello.
The user is able to create _boards_ in which they can add _tasks_. Each board can include a list of _labels_, and each task can be assigned a label. Each label has its own name and color.
Aside from labels, tasks can also include a description. 

Some Android development concepts used to build this app are: DrawerLayout, CardView, Fragments, Menus, Navigation using Intents, Styles including a custom Action Bar and status bar, overall UI design in XML, custom drawables, RecyclerView, other Adapter Views.  

## How to run
- Open Android Studio
- Select _Get from VCS_
- Paste the link to this repository
- Run the app on a Virtual Android Device

## How to use 
The home page features quick access to your most recent board (most recently opened or created), as well as quick access to creating a new board.
Each board requires a name and the default board color can be changed.
Inside a board, the options menu in the upper right corner provides access to the list of this board's labels, where the user can add new ones.
The button in the lower right corner takes the user to a page where they can create a new task, which requires a name. The user can optionally provide a description, as well as select one of the board's labels.
When viewing the task list, the user can tap on a task to show/hide the full description. A long click provides a context menu where the task can be deleted or marked as completed/uncompleted.

___Compatibility:___ _Android Target API: 31_
