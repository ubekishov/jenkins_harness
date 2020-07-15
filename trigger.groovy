#!/usr/local/bin/ groovy

/***************************************************************************************
*    Title: Groovy to call Harness workflow
*    Author: Ulan Bekishov
*    Date: 7/15/2020
***************************************************************************************/

//Get parameters from Harness manual trigger cURL command
//application - application ID for which trigger is setup
//parameters - Worflow or Pipeline variables that need to be populated dynamically
//webhookurl - pull this from manual trigger

def wf_parameters = '{"application":"HARNESS_APPLICATION_ID","parameters":{"servicename":"servicename_placeholder","envname":"envname_placeholder","dockerfile":"dockerfile_placeholder"}}'
def webhookurl = "WEBHOOKURL"

def response = ['bash', '-c', "curl -X POST -H \"content-type: application/json\" --url '${webhookurl}' -d '${wf_parameters}'" ].execute()

response.waitFor()
println response.err.text
println response.text
