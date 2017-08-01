import plivo

auth_id = "MAMGVJN2RKN2RMNZLLOT"
auth_token = "YjgzMTAwNmVhMTkxMGNmMGNmMTg1MDFlM2FlNjdh"
p = plivo.RestAPI(auth_id, auth_token)

# param = {'src': '+919999186655', 'dst' : '+919999186655', 'text' : u"Hello, how are you?"}

params = {
    'to': '+919999871626',
    'from' : '+919999871626',
    'answer_url' : "https://s3.amazonaws.com/static.plivo.com/answer.xml",
    'answer_method' : "GET"
}
response = p.make_call(params)
print str(response)
#response = p.send_message(param)