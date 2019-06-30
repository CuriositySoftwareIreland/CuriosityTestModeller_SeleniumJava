zip -r data/unresolvedData.zip data/unresolved/*

java -jar lib/JobSubmission/java/JobSubmission.jar "ResolveSetting.xml" "data/ResultOutput.zip"

unzip  data/ResultOutput.zip -d data/ResultOutput

cp -a data/ResultOutput/ResolvedFiles/. data/resolved/ /source/. /dest/

rm -rf data/ResultOutput

rm -f data/unresolvedData.zip

rm -f data/ResultOutput.zip