# csa-self-study
Code repository for members of the AP Computer Science A self-study.

![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot") ![Party Parrot](https://ppaas.herokuapp.com/partyparrot "Party Parrot")

## Get setup

1. Clone this repository into your Documents folder (or somewhere else of your choosing) ([install Git](https://git-scm.com/book/id/v2/Getting-Started-Installing-Git) if you haven't already)
   * `$ cd ~/Documents && git clone https://github.com/brycemck/csa-self-study.git`
2. Set your workspace to the cloned folder
   * Make sure eclipse will ask you to choose your workspace by checking this box in Preferences:
    ![alt text](http://brycemckenney.co/git-screenshots/1.jpg "Check this Box")
   * Quit Eclipse and reopen. Set your workspace to be your new cloned folder.
    ![alt text](http://brycemckenney.co/git-screenshots/2.jpg "Choose your Workspace")
3. Import existing projects
   * Navigate to File > Import...
   * Expand "General"
   * Select "Existing Projects into Workspace" and click Next >
   * Click "Browse" next to "Select Root Directory"
   * Navigate to the cloned folder on your computer (~/Documents/csa-self-study) and click Open
   * Click Finish

## Start a new project

1. Select the `zz-template` project from the Package Explorer
2. Cmd/Ctrl + C to copy
3. Cmd/Ctrl + V to paste
4. Name the new project whatever you like
5. Navigate to your package, and rename the file and class to whatever you want.

## Pushing changes to GitHub

1. After making changes to your code, you'll want to first pull any other changes made by anyone else to your computer to avoid any conflicts.
   * `$ cd /path/to/csa-self-study && git pull`
2. Now, check to see if you need to add anything to the code push.
   * `$ git status`
3. If there are any files listed under "Untracked files", run the following. This adds any newly created files to the code push. Otherwise, skip this step.
   * `$ git add .`
4. Now, you're ready to push your code. First you need to add a "commit" message, describing what you changed or added.
   * `$ git commit -am 'YOUR MESSAGE HERE'`
5. You should've seen a summary of file changes that were entered into that commit. Now, push to Git!
   * `$ git push`

## Helpful links

* [Party Parrots](http://cultofthepartyparrot.com/)