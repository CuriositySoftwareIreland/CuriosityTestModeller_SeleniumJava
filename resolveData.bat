7z a data/unresolvedData.zip ./data/unresolved/*

java -jar lib/JobSubmission/java/JobSubmission.jar "ResolveSettingLocal.xml" "data/ResultOutput.zip"

7z x data/ResultOutput.zip -odata/ResultOutput

xcopy data\ResultOutput\ResolvedFiles data\resolved /y

rmdir /S /Q data\ResultOutput

del /Q data\unresolvedData.zip

del /Q data\ResultOutput.zip