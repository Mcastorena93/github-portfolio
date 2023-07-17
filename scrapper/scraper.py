from bs4 import BeautifulSoup
import requests

url_to_scrape = "https://magic.wizards.com/en/keyword-glossary"

html_content = requests.get(url_to_scrape).text

html_soup = BeautifulSoup(html_content, 'html.parser')

answer = html_soup.find_all('p')
 
keywords = html_soup.find_all('h3')

filename = 'Keywords.csv'
f = open(filename, 'w')

headers = 'Keyword abilities, Definitions \n'

f.write(headers)
print(len(answer))
print(len(keywords))

for i, paragraphs in enumerate(answer):
    if(i<11):
        answer.pop(i)
        keywords.pop(i)

for i, glossary in enumerate(answer):

    keyword = keywords[i].get_text()
    definition = glossary.get_text()
    f.write(keyword + ',' + definition + '\n') 
        
    

     

    

    
    

f.close()