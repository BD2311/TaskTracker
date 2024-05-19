# TaskTracker
## Table of Contents:

[Project Proposal](https://github.com/BD2311/TaskTracker/#project-proposal)

[Features/Objectives](https://github.com/BD2311/TaskTracker/#featuresobjectives)

[Requirement Traceability Matrix](https://github.com/BD2311/TaskTracker/#requirement-traceability-matrix)

[CRC Card Diagram](https://github.com/BD2311/TaskTracker/#crc-card-diagram)

[Graphical User Interface Wireframe](https://github.com/BD2311/TaskTracker/#graphical-user-interface-wireframe)

[Weekly Checkpoints](https://github.com/BD2311/TaskTracker/#weekly-checkpoints)



### Project Proposal
TaskTracker is a utility programmed in Java designed to automate the tracking of progress on tasks.

### Features/Objectives
- User will be able to create different types of tasks such as work task or personal task
- User will be able to add requirements to each task
- User will be able to check off requirements and system will automatically mark tasks as complete if all requirements are checked off
- User will be able to forcibly mark a task as complete even if a requirement is not fulfilled
- User will be able to add a new requirement to a task even if the task is complete which will move the task to be in progress

### Requirement Traceability Matrix
| Requirement | Source File | Test Status |
|    :---:    |    :---:    |     ---:    |
| Requirement can be set to complete | RequirementPanel.java | Pass |
| Task name can be set and accessed | TaskPanel.java | Pass |
| Requirement can be added and removed from Task | TaskPanel.java | Pass |
| Can check if all requirements in task is complete | TaskPanel.java | Pass |
| Can set a task to complete | TaskPanel.java | Pass |
| Category name can be set and accessed | CategoryPanel.java | Pass |
| Task can be added and removed from Category | CategoryPanel.java | Pass |
| Task can be moved from Category to another Category | CategoryPanel.java | Pass |

### CRC Card Diagram
![TaskTrackerClassDiagram](https://github.com/BD2311/TaskTracker/assets/164386430/5cf94afe-ae8d-4d34-9f54-074a8bfa1dcd)

### Graphical User Interface Wireframe
![TaskTrackerGUISketch](https://github.com/BD2311/TaskTracker/assets/164386430/44cea94e-fa3c-41aa-b440-549782d90872)
