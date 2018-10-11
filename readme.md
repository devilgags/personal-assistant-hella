## Hella Alexa Services
This assistant introduces me when I say "Alexa, Introduce me !"
It also tells funny things about my friends.

Following configurations needed to be done while creating a lambda  

1. __Type__: AWS Lambda Function
2. __Runtime__ : Java 8
3. __Handler__: com.mindtree.venussilkalexaservices.handler.VenusSilkAlexaServicesHandler
4. __Ram__: 512 MB
5. __Timeout__: 30 Sec
6. __Role__: Role should include permission to invoke other lambda function
7. __Triggers__: Alexa Skill Kit
8. __Dependency__: ##

### For intent, utterences and custom data types used to create and train models look here
1. [Intents JSON](extras/alexa skill kit data/intent.json)
2. [Utterances](extras/alexa skill kit data/utterances)
3. [Custom Data Types](extras/alexa skill kit data/custom-data-types)
