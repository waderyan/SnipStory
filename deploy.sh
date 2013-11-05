# Log into aws
# Make sure you have snipstory.pem 
ssh -i -v snipstory.pem ubuntu@ec2-54-200-212-168.us-west-2.compute.amazonaws.com


# back up database
function backupDB {
	_now=$(date +"%m_%d_%Y");
	_file="$HOME/backups/$1_backup_$_now.sql";
	touch "$_file";
	echo "Starting backup to $_file ..."
	mysqldump -u root -psnipstory $1 > "$_file";
}

backupDB invitees
backupDB snipstory

# pull in new code
git pull origin master
# may need to enter in git credentials

function restartSnipStory {
	cd $HOME/SnipStory 
	_pid=$(cat RUNNING_PID)
	# Reads the password from stdin
	echo "Killing existing process"
	echo snipstory | sudo -S kill $_pid
	echo "Restarting play"
	sudo play "start 80"
}

restartSnipStory
