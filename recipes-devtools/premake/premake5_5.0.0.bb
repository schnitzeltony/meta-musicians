SUMMARY = "A simple build configuration and project generation tool using lua"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4d2a821a590b53e6ca55241102be4dbe"
HOMEPAGE = "http://premake.github.io/"

SRC_URI = " \
    https://github.com/premake/premake-core/releases/download/v5.0.0-alpha14/premake-5.0.0-alpha14-src.zip \
"
SRC_URI[md5sum] = "f26699599c53865f7b154e9ed22a0ba4"
SRC_URI[sha256sum] = "7c9fa4488156625c819dd03f2b48bfd4712fbfabdc2b5768e8c7f52dd7d16608"
S = "${WORKDIR}/premake-${PV}-alpha14"

BBCLASSEXTEND = "native"

do_compile_prepend() {
    cd ${S}/build/gmake.unix
    export config=debug
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${S}/bin/debug/premake5 ${D}${bindir}
}


