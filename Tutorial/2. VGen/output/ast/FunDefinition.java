/**
 * @generated VGen (for ANTLR) 1.7.0
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	funDefinition:definition -> name:String  params:definition*  return_t:type  definitions:varDefinition*  sentences:sentence*

public class FunDefinition extends AbstractDefinition {

	public FunDefinition(String name, List<Definition> params, Type return_t, List<VarDefinition> definitions, List<Sentence> sentences) {
		this.name = name;
		this.params = params;
		this.return_t = return_t;
		this.definitions = definitions;
		this.sentences = sentences;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(params, return_t, definitions, sentences);
	}

	public FunDefinition(Object name, Object params, Object return_t, Object definitions, Object sentences) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.params = this.<Definition>getAstFromContexts(params);
		this.return_t = (Type) getAST(return_t);
		this.definitions = this.<VarDefinition>getAstFromContexts(definitions);
		this.sentences = this.<Sentence>getAstFromContexts(sentences);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, params, return_t, definitions, sentences);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Definition> getParams() {
		return params;
	}
	public void setParams(List<Definition> params) {
		this.params = params;
	}

	public Type getReturn_t() {
		return return_t;
	}
	public void setReturn_t(Type return_t) {
		this.return_t = return_t;
	}

	public List<VarDefinition> getDefinitions() {
		return definitions;
	}
	public void setDefinitions(List<VarDefinition> definitions) {
		this.definitions = definitions;
	}

	public List<Sentence> getSentences() {
		return sentences;
	}
	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Definition> params;
	private Type return_t;
	private List<VarDefinition> definitions;
	private List<Sentence> sentences;

	public String toString() {
       return "{name:" + getName() + ", params:" + getParams() + ", return_t:" + getReturn_t() + ", definitions:" + getDefinitions() + ", sentences:" + getSentences() + "}";
   }
}
