SUMMARY = "Audacity is an easy-to-use, multi-track audio editor and recorder"
HOMEPAGE = "https://www.audacityteam.org/"
LICENSE = "GPL-2.0-only & CC-BY-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=549b88b1c547acbec8f9e262f30b573e"

PV = "2.4.2"
SRC_URI = " \
    git://github.com/audacity/audacity.git;branch=master;protocol=https \
    file://0001-Do-not-ask-git-for-version-information-it-breaks-bui.patch \
"
SRCREV ="16d52f63a4183bba77ef7305d14622958dc0d1d5"
S = "${WORKDIR}/git"

DEPENDS = " \
    wxwidgets \
    lame \
    soxr \
    portaudio-v19 \
    portmidi \
    alsa-lib \
    jack \
    libid3tag \
    ffmpeg \
    libmad \
    vamp-plugin-sdk \
    libogg \
    libvorbis \
    flac \
    lv2 \
    lilv \
    serd \
    sord \
    sratom \
    suil \
    soundtouch \
"

inherit cmake pkgconfig python3native gettext gtk-icon-cache mime mime-xdg

do_configure:append() {
    # do set version 
    # see 0001-Do-not-ask-git-for-version-information-it-breaks-bui.patch
    # and ${S}/cmake-proxies/cmake-modules/Version.cmake. Think it erros out 
    # because it assumes execution in source dir
    cd ${S}
    git show -s "--format=#define REV_LONG \"%H\"%n#define REV_TIME \"%cd\"%n" >> ${B}/src/private/RevisionIdent.h
}

FILES:${PN} += " \
    ${datadir}/appdata \
    ${datadir}/mime \
"
