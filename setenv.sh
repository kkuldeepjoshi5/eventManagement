JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_51.jdk/Contents/Home; export JAVA_HOME
IPATSHALA_DEV_HOME=/Users/jitender/Documents/workspace/brnQA; export IPATSHALA_DEV_HOME
EXTERNAL_HOME=$IPATSHALA_DEV_HOME/external; export EXTERNAL_HOME
ANT_HOME=$EXTERNAL_HOME/tools/ant; export ANT_HOME
PATH=$JAVA_HOME/bin:$ANT_HOME/bin:$PATH; export PATH
echo "done";